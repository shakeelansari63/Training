using System;

namespace App03.StringChallenge
{
    class Program
    {
        static void Main(string[] args)
        {
            string myStr;
            System.Console.Write("Please enter your name and press enter: ");
            myStr = Console.ReadLine();

            System.Console.WriteLine($"Upper Case: {myStr.ToUpper()}");
            System.Console.WriteLine($"Lower Case: {myStr.ToLower()}");
            System.Console.WriteLine($"Trimmed: {myStr.Trim()}");
            System.Console.WriteLine($"Substring: {myStr.Substring(3, 3)}");

            System.Console.Write("Enter a string here: ");
            myStr = Console.ReadLine();

            System.Console.Write("Enter character to search: ");
            char searchChar = (char)Console.Read();
            Console.ReadKey();

            System.Console.WriteLine($"Index of {searchChar} in {myStr} is {myStr.IndexOf(searchChar)}");

            System.Console.Write("Enter First name: ");
            string firstName = Console.ReadLine();
            
            System.Console.WriteLine();
            System.Console.Write("Enter Last name: ");
            string lastName = Console.ReadLine();

            string fullName = String.Format("{0} {1}", firstName.Trim(), lastName.Trim());

            System.Console.WriteLine($"Full name is {fullName}");
        }
    }
}
