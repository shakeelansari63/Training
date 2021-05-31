// Import Header Object from components
import Header from './components/Header'
import Tasks from './components/Tasks'

// Import useStates
import { useState } from 'react'

// This is main app which is embedded in 
function App() {
  // We will maintain data in App which will be global Scope
  const [tasks, setTasks] = useState(
    [
      {
        id: 1,
        text: 'Go to School',
        day: 'May 30 2021 12 PM',
        reminder: true,
      },
      {
        id: 2,
        text: 'Search Breakfast',
        day: 'May 31 2021 7 AM',
        reminder: true,
      },
      {
        id: 3,
        text: 'Food Shopping',
        day: 'June 1 2021 5 PM',
        reminder: false,
      },

    ]
  )

  return (
    <div className="container">
      {/* This is JSX object and it does not support either JS or HTML comments
      Here comments are stored inside {} */}
      {/* <h1>Hello From React</h1> 
      Lets Put the Header tag to call Header object*/}
      <Header />

      {/** Display tasks */}
      <Tasks key={tasks.id} tasks={tasks} />
    </div>
  );
}

export default App;
