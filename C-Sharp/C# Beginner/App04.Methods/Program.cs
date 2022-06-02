using System;

namespace App04.Methods
{
    class Program
    {
        static void Main(string[] args)
        {
            MethodWithoutParamAndReturn();

            MethodWithParameters("Some string goes here");
            
            Console.WriteLine(MethodWithParameterAndReturn("My new param string"));

            UserInput();
        }
        
        // We can only access static methods from other static methods.
        // Since Main is static, this method also need to be static
        private static void MethodWithoutParamAndReturn()
        {
            Console.WriteLine("Hello I am method without any parameter and return value");
        }
        
        // Method with parameter but no return value
        private static void MethodWithParameters(string someParam)
        {
            Console.WriteLine("Hello this is your parameter - " + someParam);
        }
        
        // Method with parameter and return value
        private static string MethodWithParameterAndReturn(string someParam)
        {
            return "Hello this is new string and we will return this with - " + someParam;
        }
        
        // Method which has User input
        private static void UserInput()
        {
            Console.WriteLine("Enter Some String");
            string inp = Console.ReadLine();
            
            Console.WriteLine(inp);
        }
    }
}
