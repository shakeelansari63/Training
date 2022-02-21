using System;

namespace App04.Methods
{
    class Program
    {
        static void Main(string[] args)
        {
            MethodWithoutParamAndReturn();

            MethodWithParameters("Some string goes here");
        }
        
        // We can only access static methods from otehr static metods.
        // Since Main is static, this method also need to be static
        public static void MethodWithoutParamAndReturn()
        {
            Console.WriteLine("Hello I am method without any parameter and return value");
        }

        public static void MethodWithParameters(string someParam)
        {
            Console.WriteLine("Hello this is your parameter - " + someParam);
        }
    }
}
