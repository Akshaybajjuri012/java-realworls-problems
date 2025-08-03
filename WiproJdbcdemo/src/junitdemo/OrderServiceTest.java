package junitdemo;
import org.junit.Test;
import static org.junit.Assert.*;
interface PaymentService {
    void processPayment();
}
class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService PaymentService) {
        this.paymentService = PaymentService;
    }
    public void placeOrder() {
        // Business logic
        paymentService.processPayment();
    }
}
class FakePaymentService implements PaymentService {
    int callCount = 0;

    @Override
    public void processPayment() {
        callCount++;
    }

    public int getCallCount() {
        return callCount;
    }
}
public class OrderServiceTest {

    @Test
    public void testPlaceOrder_CallsProcessPaymentOnce() {
        // Arrange
        FakePaymentService fakePaymentService = new FakePaymentService();
        OrderService orderService = new OrderService(fakePaymentService);

        // Act
        orderService.placeOrder();

        // Assert
        assertEquals(1, fakePaymentService.getCallCount());
    }

	public void processPayment() {
		// TODO Auto-generated method stub
		
	}
}
