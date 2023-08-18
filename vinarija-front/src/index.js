import React, { useState } from 'react';
import { createRoot } from 'react-dom/client';
import { Route, Link, BrowserRouter as Router, Routes, Navigate } from 'react-router-dom';
import { Button, Container, Nav, Navbar } from 'react-bootstrap';
import Home from './components/Home';
import './index.css'
import Login from './components/autorization/Login';
import { logout } from './service/auth'
import Registracija from './components/autorization/Registracija';
import NotFound from './components/NotFound';
import Korisnici from './components/korisnici/Korisnici';
import {Rola} from './service/auth'
import { korisnickoIme } from './service/auth';
import Korisnik from './components/korisnici/Korisnik';
import Vina from './components/vina/vina';
import NovoVino from './components/vina/DodajVino';

const App = () => {
  const [zaIzmenu, setZaIzmenu] = useState({})

        if (window.localStorage['jwt']) {
            return (
              <div>
              <Router>
                <Navbar className="navbar-large" expand bg="dark" variant="dark" fixed="top">
                <Navbar.Brand as={Link} to="/">
                Vinarija
                  </Navbar.Brand>
                  <Nav className="navbar-links-center">
                    <Nav.Link className="text-white bg-dark" as={Link} to="/vina">
                      Vina
                    </Nav.Link>
                    {Rola() == "admin" && <Nav.Link className="text-white bg-dark" as={Link} to="/korisnici">
                      Korisnici
                    </Nav.Link>}
                  </Nav>
                  <Nav.Link className="text-white bg-dark" as={Link} to="/korisnik">
                      <h5>{korisnickoIme()}</h5>
                   </Nav.Link>
                    <Button className="btn btn-light" onClick={logout}>Logout</Button>
                </Navbar>
                <Container style={{paddingTop:"25px"}}>
                  <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/vina" element={<Vina/>}/>
                    <Route path="/vino/add" element={<NovoVino/>}/>
                    <Route path="/korisnici" element={<Korisnici/>}/>
                    <Route path="/korisnik" element={<Korisnik/>}/>
                    <Route path="*" element={<NotFound/>} />
                  </Routes>
                </Container>
              </Router>
              <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
              <Navbar bg="dark" variant="dark">
                <Navbar.Brand>&copy; 2023 JWD</Navbar.Brand>
              </Navbar>
            </div>
              );
        } else {
            return (
              <div>
              <Router>
                <Navbar className="navbar-large" expand bg="dark" variant="dark" fixed="top">
                <Navbar.Brand as={Link} to="/">
                Vinarija
                  </Navbar.Brand>
                  <Nav className="navbar-links-center">
                    <Nav.Link className="text-white bg-dark" as={Link} to="/vina">
                    Vina
                    </Nav.Link>
                  </Nav>
                  <Nav.Link className="text-white bg-dark" as={Link} to="/registracija">
                      Registracija
                   </Nav.Link>
                    <Button className="btn btn-light" as={Link} to="/login">Login</Button>
                </Navbar>
                <Container style={{paddingTop:"25px"}}>
                  <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/login" element={<Login/>}/>
                    <Route path="/vina" element={<Vina/>}/>
                    <Route path="/registracija" element={<Registracija/>}/>
                    <Route path="*" element={<Navigate replace to = "/login" />} />
                  </Routes>
                </Container>
              </Router>
              <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
              <Navbar bg="dark" variant="dark">
                <Navbar.Brand>&copy; 2023 JWD</Navbar.Brand>
              </Navbar>
            </div>
              );
        }
  }

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App />,
);
