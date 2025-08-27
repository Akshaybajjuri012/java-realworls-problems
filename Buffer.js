// 1. Create a Buffer of size 256 bytes
let buffer = Buffer.alloc(256);

// First student record
const student1 = { id: 1, name: "Thananya", age: 20, grade: "A" };
const student1Str = JSON.stringify(student1);

// 2. Write Data to Buffer
let bytesWritten1 = buffer.write(student1Str, "utf8");
console.log("Bytes written to buffer:", bytesWritten1);

// Display buffer content as string
let bufferContent1 = buffer.toString("utf8", 0, bytesWritten1);
console.log("Buffer content as string:", bufferContent1);

// 3. Read Data from Buffer
let parsedStudent1 = JSON.parse(bufferContent1);
console.log("Parsed Student Data:");
console.log("ID:", parsedStudent1.id);
console.log("Name:", parsedStudent1.name);
console.log("Age:", parsedStudent1.age);
console.log("Grade:", parsedStudent1.grade);

// 4. Buffer Operations
// Append another student record (if space permits)
const student2 = { id: 2, name: "Michael", age: 21, grade: "B" };
const student2Str = JSON.stringify(student2);

// Write student2 after student1 in the same buffer
let bytesWritten2 = buffer.write(student2Str, bytesWritten1, "utf8");
console.log("\nAppended second student record.");

// Read FULL buffer content (student1 + student2)
let fullContent = buffer.toString("utf8", 0, bytesWritten1 + bytesWritten2);
console.log("Full Buffer content:", fullContent);

// Slice buffer to read only the first student
let firstStudentBuffer = buffer.slice(0, bytesWritten1);
console.log("First Student Slice:", firstStudentBuffer.toString());

// Copy data from one buffer to another
let copyBuffer = Buffer.alloc(256);
firstStudentBuffer.copy(copyBuffer, 0, 0, firstStudentBuffer.length);
console.log("Copied Buffer Content:", copyBuffer.toString("utf8", 0, firstStudentBuffer.length));

// 5. Encoding & Decoding
console.log("\nEncodings Demonstration:");
console.log("UTF8:", buffer.toString("utf8", 0, bytesWritten1));
console.log("ASCII:", buffer.toString("ascii", 0, bytesWritten1));
console.log("Base64:", buffer.toString("base64", 0, bytesWritten1));
