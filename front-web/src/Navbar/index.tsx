import './styles.css';
import { ReactComponent as Logo}  from './Logo.svg';
import { Link } from 'react-router-dom';


function Navbar(){
    return(
        <nav className="main-navbar">
            <Link to="/" className="logo-text"> Delivery SUS</Link>
        </nav>
    );

}

export default Navbar;