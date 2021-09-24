using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace vega.Model
{
    public class Model
    {
        public int Id { get; set; }
        public string Name { get; set; }

        // This is inverse reference to Make class since Make class has models object
        // Following code is interepreted by Code First Model and Entity framework will not create any new column for this
        public Make Make { get; set; }

        // This is reference to ID from Make and it is interpreted Entity Framework in code first strategy
        public int MakeId { get; set; }
    }
}