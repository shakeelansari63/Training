// Import Header Object from components
import Header from './components/Header'
import Tasks from './components/Tasks'
import AddTask from './components/AddTask'

// Import useStates
import { useState } from 'react'

// This is main app which is embedded in 
function App() {
  // States for Showing and hiding Add Task Form
  const [formView, setFormView] = useState(false)

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

  const createTask = (task) => {
    // generate an Id 
    // Map will return list of ids
    // Math.max calculate max from the list
    const id = Math.max(...(tasks.map((task) => task.id))) + 1

    const newTask = { ...task, id: id }

    console.log(newTask)

    // Adding task to state
    const newTasks = [...tasks, newTask]
    setTasks(newTasks)
  }

  return (
    <>
      <div className='container' style={{ backgroundColor: 'red', color: 'white' }} >
        <h1>React Crash Course</h1>
      </div>
      <div className="container">
        {/* This is JSX object and it does not support either JS or HTML comments
      Here comments are stored inside {} */}
        {/* <h1>Hello From React</h1> 
      Lets Put the Header tag to call Header object*/}
        <Header formViewToggle={() => setFormView(!formView)} curFormView={formView} />

        {/**Display Add Task Form only if FormView is true */}
        {formView && <AddTask onAdd={createTask} />}

        {/** Display tasks */}
        {tasks.length > 0 ?
          <Tasks tasks={tasks} onDelete={deleteTask} onToggle={toggleReminder} /> :
          <p>No Tasks to show</p>
        }
      </div>
    </>
  );
}

export default App;
