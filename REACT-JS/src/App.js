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

  const deleteTask = (taskId) => {
    console.log(taskId + ' Deleted !!')

    // To Delete the task, we have to use SetTask state
    const newTask = tasks.filter((task) => task.id !== taskId)
    setTasks(newTask)
  }

  const toggleReminder = (taskId) => {
    console.log(taskId + ' reminder updated !!')

    // To update reminder, we have to create new task
    const newTask = tasks.map((task) =>
      task.id === taskId ? { ...task, reminder: !task.reminder } : task
    )
    setTasks(newTask)
  }

  return (
    <div className="container">
      {/* This is JSX object and it does not support either JS or HTML comments
      Here comments are stored inside {} */}
      {/* <h1>Hello From React</h1> 
      Lets Put the Header tag to call Header object*/}
      <Header />

      {/** Display tasks */}
      { tasks.length > 0 ?
        <Tasks tasks={tasks} onDelete={deleteTask} onToggle={toggleReminder} /> :
        <p>No Tasks to show</p>
      }
    </div>
  );
}

export default App;
