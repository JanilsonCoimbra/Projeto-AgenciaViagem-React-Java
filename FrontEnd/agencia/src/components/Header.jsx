import React from 'react'
import { Link } from 'react-router-dom'
import styles from './header.module.css'


function Header() {
    return (
        <>
        <div className={styles.topo}>
        <nav className="navbar navbar-expand-lg navbar-light bg-light" >
            <div className="container-fluid bg-light">
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="w-25 "><img className={styles.img} src='./img/logo.png' /></div>
                <div className="collapse navbar-collapse" id="navbarTogglerDemo03">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item">
                            <Link className="nav-link" to="/">Home</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/Destinos">Destinos</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/Quemsomos">Quem Somos</Link>
                        </li>
                        <li className="nav-item">
                        <Link className="nav-link" to="/Contatos">Contatos</Link>
                        </li>
                    </ul>
                    <form className="d-flex">
                        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                        <button className="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        </div>
        <div className={styles.topoFundo}></div>
        </>
    )
}
export default Header