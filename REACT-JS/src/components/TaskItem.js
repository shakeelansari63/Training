// If we have installed react icons we can use FontAwesome icons
import { FaTimes } from 'react-icons/fa'
// task Item class to show individual task Item
const TaskItem = ({ task }) => {
    return (
        <div className='task'>
            <h3> {task.text} <FaTimes style={{ color: 'red', cursor: 'pointer' }} /></h3>
            <p>{task.day}</p>
        </div>
    );
}

export default TaskItem