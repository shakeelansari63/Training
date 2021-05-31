// Import Header Object from components
import Header from './components/Header'
import Tasks from './components/Tasks'
import AddTask from './components/AddTask'

// Import useStates & useEffect to load something in beginning
import { useState, useEffect } from 'react'

// This is main app which is embedded in 
function App() {
  // States for Showing and hiding Add Task Form
  const [formView, setFormView] = useState(false)

  // We will maintain data in App which will be global Scope
  const [tasks, setTasks] = useState([])

  // Function to fetch Json data from API
  const apiUrl = 'http://localhost:5000/tasks'

  const fetchTasks = async () => {
    const resp = await fetch(apiUrl)
    const tasks = await resp.json()

    return tasks
  }

  // Method to fetch individual task from server
  const fetchTask = async (id) => {
    const getUrl = `${apiUrl}/${id}`
    const resp = await fetch(getUrl)
    const task = await resp.json()

    return task
  }

  // Lets use useEffect to call API Url as soon as page laods
  useEffect(() => {
    // Define function for async get
    const getTasks = async () => {
      const tasks = await fetchTasks()
      setTasks(tasks)
    }

    // Call Async function to get data and set State
    getTasks();
  }, [])

  // Delete Task from UI and Backend
  const deleteTask = async (taskId) => {
    console.log(taskId + ' Deleted !!');

    // Delete task from backend
    const delUrl = `${apiUrl}/${taskId}`;
    await fetch(delUrl, { method: 'DELETE' });

    // To Delete the task, we have to use SetTask state
    const newTask = tasks.filter((task) => task.id !== taskId);
    setTasks(newTask);
  };

  // Update reminder in backend and UI
  const toggleReminder = async (taskId) => {
    console.log(taskId + ' reminder updated !!')

    // Update URl
    const updUrl = `${apiUrl}/${taskId}`

    // Get Task current data
    const oldTask = await fetchTask(taskId);
    // udpate Task reminder
    const newTask = { ...oldTask, reminder: !oldTask.reminder }

    console.log(newTask)

    // Update the backend
    const resp = await fetch(updUrl, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      }, body: JSON.stringify(newTask)
    })

    const data = await resp.json()

    // To update reminder, we have to create new task
    const newTasks = tasks.map((task) =>
      task.id === taskId ? data : task
    )

    setTasks(newTasks)
  }

  // Add task in Backend and UI
  const createTask = async (task) => {
    // generate an Id 
    // Map will return list of ids
    // Math.max calculate max from the list
    const id = Math.max(...(tasks.map((task) => task.id))) + 1

    const newTask = { ...task, id: id }

    console.log(newTask)

    // Update backend
    const resp = await fetch(apiUrl, {
      method: 'POST', headers: {
        'Content-Type': 'application/json'
      }, body: JSON.stringify(newTask)
    });

    const data = await resp.json()

    // Adding task to state
    const newTasks = [...tasks, data]
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
