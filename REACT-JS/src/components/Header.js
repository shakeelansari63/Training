//This is Header object 
// Header objects can either have class of function, we will use fuction

import Button from "./Button"

// Js objects can accept parameters in form of props. 
// For example we can define title='XYZ' in Appjs for Header like 
// <Header title='hello World'/>, to in order to catch the title, use props

// And Lastly, if we are using router, we would not need Add button on About page
// This can be achieved by chekcing current path and show the button only if currnt path is '/'
import { useLocation } from 'react-router-dom'

const Header = (props) => {

    // Check current location
    const curLocation = useLocation()

    // return JSX Object
    return (
        <header className='header'>
            <h1>{props.title}</h1>
            {/** Instead of using button we can have re-usable button component
                 * And We can pass props to customise them
                 * <button className='btn'>Add</button>
                 */}
            {curLocation.pathname === '/' && <Button color={props.curFormView ? 'red' : 'green'}
                text={props.curFormView ? 'Close' : 'Add'}
                onClick={props.formViewToggle} />}
        </header>
    );
}

// But if prop is not pssed in, we can have default props to use
Header.defaultProps = {
    title: 'Task Tracker'
}

// We can also have dynamic styling for every object
// const headerStyle = {
//     color: 'red',
//     backgroundColor: 'black'
// }

export default Header