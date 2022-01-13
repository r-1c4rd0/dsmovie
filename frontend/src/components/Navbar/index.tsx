import { ReactComponent as GithubIcon } from 'assets/img/github.svg'
import './styles.css'


function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DSMovie</h1>
                    <a href="https://github.com/r-1c4rd0">
                        <div className="dsmovie-contact-container">
                            <GithubIcon />
                            <p className="dsmovie-contact-link">/r-1c4rd0</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;