import React, { useCallback, useEffect, useState } from 'react'
import { Button, Col, Collapse, Form, Row, Table } from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import Axios from '../../apis/Axios';
import {IsLoggedIn} from '../../service/auth'
import '../../index.css'
import { Rola } from '../../service/auth'

const Vina = () => {

    var navigate = useNavigate()
    const [vina, setVina] = useState([])
    const [vinarije, setVinarije] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [totalPage, setTotalPage] = useState(0)
    const [isChecked, setIsChecked] = useState(false);
    const [kolicinaVina, setKolicinaVina] = useState({
        kolicinaZaIzmenu: 0
    })
    const [searchParams, setSearchParams] = useState({
      ime: "",
      vinarijaId: ""
    })
  
    const getAll = useCallback((nextPage) => {
        const config = {
          params: {
            ime: searchParams.ime,
            vinarijaId: searchParams.vinarijaId,
            pageNo: nextPage
          }
        }
        Axios.get('/vina', config)
        .then(res => {
          console.log(res)
          setVina(res.data)
          setPageNo(nextPage)
          setTotalPage(res.headers["total-pages"])
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

    const getAll2 = useCallback(() => {
      Axios.get('/vinarije')
      .then(res => {
        console.log(res)
        setVinarije(res.data)
      })
      .catch(err => {
        console.log(err)
      })
    }, [])
  
    useEffect(() => {
      getAll(pageNo)
      getAll2()
    }, [])

    const goToAdd = () => {
      navigate('/vino/add')
    }

    const delte = (vinoId) => {
      const confirmDelete = window.confirm("Da li ste sigurni da zelite da obrisete ovaj vino?");
      if (confirmDelete) {
        Axios.delete('/vina/' + vinoId)
        .then(res => {
          console.log(res)
          setVina((vina)=>vina.filter(vino => vino.id !== vinoId))
        })
        .catch(err => {
          console.log(err)
        })
      } else {
        navigate('/vina')
      }
    }

    const narucivanje = (vinoId) => {
        const potvrdaStanja = window.confirm("Da li ste sigurni da zelite da narucite?");
        if (potvrdaStanja) {
            const dto = {
                kolicinaZaIzmenu :kolicinaVina.kolicinaZaIzmenu
            }
          Axios.put('/vina/' + vinoId +'/nabavka', dto)
          .then(res => {
            console.log(res)
            alert("Uspesno narucivanje!")
            window.location.reload()
          })
          .catch(err => {
            console.log(err)
            alert("Doslo je do greske pri narucivanju!")
          })
        } else {
          navigate('/vina')
        }
    }

    const kupovina = (vinoId, kolicina) => {
        const potvrdaStanja = window.confirm("Potvrdite kupovinu!");
        if (potvrdaStanja) {
            const dto = {
                kolicinaZaIzmenu :kolicinaVina.kolicinaZaIzmenu
            }
          Axios.put('/kupovina/' + vinoId, dto)
          .then(res => {
            console.log(res)
            alert("Uspesna kupovina!")
            window.location.reload()
          })
          .catch(err => {
            console.log(err)
            alert("Doslo je do greske pri narucivanju! " + "Preostala broj flasa vina je: " + kolicina)
          })
        } else {
          navigate('/vina')
        }
    }

    const rednerAll = () => {
      return vina.map((vino) => {
        if (vino.dostupneFlase == 0 && Rola() == "korisnik") {
            return <tr><td>Rasprodato</td></tr>;
        }
        return(
          <tr key={vino.id}>
            <td>{vino.ime}</td>
            <td>{vino.nazivVinarije}</td>
            <td>{vino.nazivtipaVina}</td>
            {Rola() == "korisnik" && <td>{vino.opis}</td>}
            <td>{vino.godinaProizvodnje}</td>
            <td>{vino.cena}</td>
            {IsLoggedIn() && Rola() == "admin" && <td>{vino.dostupneFlase}</td>}
            {IsLoggedIn() && Rola() == "admin" && <td><Button className="btn btn-danger" onClick={() => delte(vino.id)}>Ukloni</Button></td>}
            {IsLoggedIn() && Rola() == "admin" && vino.dostupneFlase < 10 &&<td><Form.Control name='kolicinaZaIzmenu' style={{ width: '100px' }} type='number' placeholder='kolicina' onChange={(e) => setKolicinaVina({kolicinaZaIzmenu : e.target.value})} ></Form.Control></td>}
            {IsLoggedIn() && Rola() == "admin" && vino.dostupneFlase < 10 &&<td><Button className="btn btn-info" onClick={() => narucivanje(vino.id)}>Naruci</Button></td>}
            {IsLoggedIn() && Rola() == "korisnik" &&<td><Form.Control name='kolicinaZaIzmenu' style={{ width: '100px' }} type='number' placeholder='kolicina' onChange={(e) => setKolicinaVina({kolicinaZaIzmenu : e.target.value})} ></Form.Control></td>}
            {IsLoggedIn() && Rola() == "korisnik" &&<td><Button className="btn btn-info" onClick={() => kupovina(vino.id, vino.dostupneFlase)}>Kupi</Button></td>}
          </tr>
        )
      })

    }

    const rednerAll2 = () => {
      return vinarije.map((vinarija) => {
        return(<option key={vinarija.id} value={vinarija.id}>{vinarija.ime}</option>)
      })

    }

    const serchValue = (event) => {
      let name = event.target.name
      let value = event.target.value
      
      searchParams[name] = value
      setSearchParams(searchParams)
      getAll(0)
    }
    
    return (
      <div>
        <Row className="justify-content-center">
        <Col>
          <br/><br/>
          <Row><h1>Vina</h1></Row>
            <Form.Group style={{marginTop:35}}>
                <Form.Check type="checkbox" label="Show search form" onClick={(event) => setIsChecked(event.target.checked)}/>
            </Form.Group>
            <Collapse in={isChecked}>
            <Form style={{marginTop:10}}>
                <Form.Group>
                    <Form.Select name='vinarijaId' onChange={serchValue}>
                        <option value={""}>--izaberi vinarija--</option>
                        {rednerAll2()}
                    </Form.Select>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Naziv</Form.Label>
                    <Form.Control type='text' name='ime' onChange={serchValue} ></Form.Control><br/>
                </Form.Group>
            </Form>
            </Collapse>
          <Row>
            <Col>
              <Table>
                <thead>
                  <tr>
                    <th>Naziv vina</th>
                    <th>Vinarija</th>
                    <th>Tip vina</th>
                    {IsLoggedIn() && Rola() == "korisnik" && <th>Opis</th>}
                    <th>Godina proizvodnje</th>
                    <th>Cena po flasi (rsd)</th>
                    {IsLoggedIn() && Rola() == "admin" && <th>Broj preostalih flasa</th>}
                    <th></th>
                    <th></th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  {rednerAll()}
                </tbody>
              </Table>
            </Col>
          </Row>
          <br/>
            {IsLoggedIn() && Rola() == "admin" && <Button className="btn btn-success" onClick={() => goToAdd()}>Kreiraj vino</Button>}
          <div style={{ display: 'flex', justifyContent: 'center' }}>
            <Button className="btn btn-light btn-sm" disabled={pageNo==0} onClick={() => getAll(pageNo-1)}>{'❮'}</Button>
            <span style={{ margin: '10px' }}> {pageNo + 1} </span> 
           <Button className="btn btn-light btn-sm" disabled={pageNo==totalPage-1 || vina.length === 0} onClick={() => getAll(pageNo+1)}>{'❯'}</Button>
          </div>
        </Col>
        </Row>
      </div>
    );
  }

export default Vina;