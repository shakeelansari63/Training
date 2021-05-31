// Import TasksItem
import TaskItem from './TaskItem'
// If we need reactive UI, we should use state for changing data
//import { useState } from 'react'
// Here is a Dummy task for us to work with
// const tasks = [
//     {
//         id: 1,
//         text: 'Go to School',
//         day: 'May 30 2021 12 PM',
//         reminder: true,
//     },
//     {
//         id: 2,
//         text: 'Search Breakfast',
//         day: 'May 31 2021 7 AM',
//         reminder: true,
//     },
//     {
//         id: 3,
//         text: 'Food Shopping',
//         day: 'June 1 2021 5 PM',
//         reminder: false,
//     },

// ]

const Tasks = ({ tasks }) => {
    // In order to use State, the tasks should become part of class
    // Lets manage the task data in outer class which can be access externally
    // const [tasks, setTasks] = useState(
    //     [
    //         {
    //             id: 1,
    //             text: 'Go to School',
    //             day: 'May 30 2021 12 PM',
    //             reminder: true,
    //         },
    //         {
    //             id: 2,
    //             text: 'Search Breakfast',
    //             day: 'May 31 2021 7 AM',
    //             reminder: true,
    //         },
    //         {
    //             id: 3,
    //             text: 'Food Shopping',
    //             day: 'June 1 2021 5 PM',
    //             reminder: false,
    //         },

    //     ]
    // )

    // Now we have setState function available and we can use this function to set new state of data
    // like 
    // settasks([...tasks], {new task object})
    return (
        // if we want to return multiple objects without parent, we can 
        // put it in empty tag
        // It is mandatory to give unique key prop if returning list
        <>
            { tasks.map((task) => (
                <TaskItem task={task} />
            ))}
        </>
    );
}

export default Tasks