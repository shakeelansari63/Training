using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Threading.Tasks;

namespace vega.Model
{
    public class Make
    {
        public int Id { get; set; }
        public string Name { get; set; }

        // Define reference to Model Class from Make class
        public ICollection<Model> Models { get; set; }

        // When you have ICollection Data type, it should be initialzed in its contructor
        public Make()
        {
            Models = new Collection<Model>();
        }
    }
}