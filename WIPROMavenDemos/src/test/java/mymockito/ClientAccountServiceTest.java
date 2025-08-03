package mymockito;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class ClientAccountServiceTest {
	private ClientAccountService.ClientAccountRepository mockRepo;
    private ClientAccountService.MessagingService mockMsg;
    private ClientAccountService service;

    @Before
    public void setup() {
        mockRepo = mock(ClientAccountService.ClientAccountRepository.class);
        mockMsg = mock(ClientAccountService.MessagingService.class);
        service = new ClientAccountService(mockRepo, mockMsg);
    }
    @Test
    public void testSuccessfulTransfer() {
        ClientAccount from = new ClientAccount("C1", 1000);
        ClientAccount to = new ClientAccount("C2", 500);

        when(mockRepo.findById("C1")).thenReturn(from);
        when(mockRepo.findById("C2")).thenReturn(to);

        boolean result = service.transfer("C1", "C2", 300);

        assertTrue(result);
        assertEquals(700, from.getBalance(), 0.001);
        assertEquals(800, to.getBalance(), 0.001);

        verify(mockRepo).update(from);
        verify(mockRepo).update(to);
        verify(mockMsg).send(from, "Transferred $300.0 to C2");
    }
    @Test
    public void testTransferFails_InsufficientFunds() {
        ClientAccount from = new ClientAccount("C1", 100);
        ClientAccount to = new ClientAccount("C2", 500);

        when(mockRepo.findById("C1")).thenReturn(from);
        when(mockRepo.findById("C2")).thenReturn(to);

        assertFalse(service.transfer("C1", "C2", 200));

        verify(mockRepo, never()).update(any());
        verify(mockMsg, never()).send(any(), anyString());
    }
    @Test
    public void testTransferFails_AccountNotFound() {
        when(mockRepo.findById("C1")).thenReturn(null);
        when(mockRepo.findById("C2")).thenReturn(new ClientAccount("C2", 500));

        assertFalse(service.transfer("C1", "C2", 50));

        when(mockRepo.findById("C1")).thenReturn(new ClientAccount("C1", 300));
        when(mockRepo.findById("C2")).thenReturn(null);

        assertFalse(service.transfer("C1", "C2", 50));

        verify(mockRepo, never()).update(any());
        verify(mockMsg, never()).send(any(), anyString());
    }

}
