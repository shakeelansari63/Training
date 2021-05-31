// Link from react router dom help to route to differnet route without refreshing whole page
import { Link } from 'react-router-dom'
const Footer = () => {
    return (
        <footer className='container'>
            <p>Copyright &copy; 2021 </p>
            <Link to='/about'>About Us</Link>
        </footer>
    );
}

export default Footer