import styles from './Rodape.module.css'
import { Link } from 'react-router-dom'
function Rodape(){
    return(<>
        <footer className="page-footer" className={styles.rodape}>
          <div className="container">
            <div className="row">
              <div className="col l6 s12">
                <h5 className="white-text">Na Bahia Turismo</h5>
                <p className="grey-text text-lighten-4">Somos especializados em te levar aos paraisos naturais e urbanos espalhados pela Bahia, temos comprometimento e foco na sua segurança.</p>
              </div>
              <div className="col l4 offset-l2 s12">
                <h5 className="white-text">Links</h5>
                <ul>
                <Link to="/Destinos" className="btn waves waves-teal">Destinos</Link>
                <Link className="nav-link" to="/Destinos">Destinos</Link>
                <Link className="nav-link" to="/Quemsomos">Quem Somos</Link>
                <Link className="nav-link" to="/Contatos">Contatos</Link>
                </ul>
              </div>
            </div>
          </div>
          <div className="footer-copyright">
            <div className="container">
            © 2021 Copyright Na Bahia Turismo
            </div>
          </div>
        </footer>
        </>
    )
    }
    export default Rodape