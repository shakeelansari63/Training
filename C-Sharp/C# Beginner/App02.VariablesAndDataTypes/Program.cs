using System;

namespace App02.VariablesAndDataTypes
{
    class Program
    {
        static void Main(string[] args)
        {
            // Desclaring a variable
            int i1;

            // Assigning value
            i1 = 10;

            // Declaration with assignment
            int i2 = 12;

            // Calculation
            int i3 = i1 + i2;

            // print 
            Console.WriteLine("i1: " + i1 + " + i2: " + i2 + " is " + i3);

            // Integer Types
            // Signed Byte is -128 to 127
            sbyte sb1 = 127;
            sbyte sb2 = -13;

            System.Console.WriteLine("Sum of sBytes: " + (sb1 + sb2));

            // Byte is 0 to 255
            byte bt1 = 24;
            byte bt2 = 243;

            System.Console.WriteLine("Sum of Bytes: " + (bt1 + bt2));

            // Integer is 2147483648 to 2147483647
            int i4 = 113124;
            int i5 = 24274412;
            System.Console.WriteLine("Sum of Ints: " + (i4 + i5));

            // Long is bigger than int
            long l1 = 132132424242142;
            long l2 = 2132324112424242;
            System.Console.WriteLine("Sum of Longs: " + (l1 + l2));

            // Float has precision of 7 decimal places
            float f1 = 3.1313f;
            float f2 = 5.122f;
            float f3 = f1 / f2;
            System.Console.WriteLine("Float Div Output: " + f3);

            // Double has precision of 15 decimal places
            double d1 = 3.1313;
            double d2 = 5.122;
            double d3 = f1 / f2;
            System.Console.WriteLine("Double Div Output: " + d3);

            // Decimal has precision of 28 deimal places
            decimal dc1 = 3.1313M;
            decimal dc2 = 5.122M;
            decimal dc3 = dc1 / dc2;
            System.Console.WriteLine("Decimal Div Output: " + dc3);

            // Boolean Types
            bool b1 = true;
            bool b2 = false;

            // Boolean types can be manipulated with relational operators
            // AND
            bool b3 = b1 && b2;
            System.Console.WriteLine("AND of true and false is: " + b3);
            
            bool b4 = b1 || b2;
            System.Console.WriteLine("OR of true and false is: " + b4);

            // Character Types store only 1 character
            char c1 = 'a';
            char c2 = '7';
            // Internally Char stores ascii value of charaters
            System.Console.WriteLine("Sum of Char types: " + (c1 + c2));

            // String types
            string s1 = "Shakeel";
            string s2 = "Hello, my name is " + s1;
            System.Console.WriteLine("String concatenated output: " + s2);
            // Strings supports multiple methods
            System.Console.WriteLine("Upper case of string " + s2.ToUpper());
            System.Console.WriteLine("Lower case of string " + s2.ToLower());

            // Console Formatting
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.ForegroundColor = ConsoleColor.Green;
            System.Console.Write("Fomatted Output");

            Console.ResetColor();

            System.Console.WriteLine();
            // Datatype Conversion
            // Implicit Conversion - Small type to Large Type
            int i6 = 66;
            long l3 = i6;
            System.Console.WriteLine($"Long {l3} is converted from Int {i6}");

            float f4 = 33.33f;
            double d4 = f4;
            System.Console.WriteLine($"Double {d4} is converted from Float {f4}");

            // Explicit Conversion, an lead to data loss
            float f5 = 13.67f;
            int i7 = (int) f5;
            System.Console.WriteLine($"Int {i7} is converted from Float {f5}");

            double d5 = 137.83829839283289;
            f5 = (float) d5;
            System.Console.WriteLine($"Float {f5} is converted from Double {d5}");

            // Conversion to String - use ToString() methods
            System.Console.WriteLine($"String {i7.ToString()} is converted from Int {i7}");

            // Parsing from String
            string s3 = "15";
            string s4 = "13";
            int i8 = Int32.Parse(s3) + Int32.Parse(s4);
            System.Console.WriteLine($"Sum of string {s3} and {s4} is {s3+s4}, But After parsing sum is {i8}");

            // Constants - Use const before Data type
            const string dob = "01-01-1990";
            System.Console.WriteLine($"My Date of Birth is always {dob} and it will never change...");

        }
    }
}
