import './styles.css';
import { ReactComponent as Logo}  from './Logo.svg';


function Navbar(){
    return(
        <nav className="main-navbar">
            <a href="home" className="logo-text"> Delivery SUS</a>
        </nav>
    );

}

export default Navbar;