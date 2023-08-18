import { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Axios from "../../apis/Axios";

const NovoVino = () => {

    const vino = {
        id: -1,
        ime: '',
        opis: '',
        godinaProizvodnje: 0,
        cena: 0,
        tipVinaId: -1,
        vinarijaId: -1

    }

    const [vinarije, setVinarije] = useState([])
    const [tipVina, setTipVina] = useState([])
    const [novoVino, setNovoVino] = useState(vino)
    var navigate = useNavigate()


    const dodaj = () => {

        const dto = {
            ime: novoVino.ime,
            opis: novoVino.opis,
            godinaProizvodnje: novoVino.godinaProizvodnje,
            cena: novoVino.cena,
            tipVinaId: novoVino.tipVinaId,
            vinarijaId: novoVino.vinarijaId
        }

        Axios.post('/vina', dto)
            .then(res => {
                console.log(res)
                navigate('/vina')
            })
            .catch(err => {
                console.log(err)
                alert("Doslo je do greske, pokusajte novi unos!")
            })
    }

    const getAll2 = useCallback(() => {
        Axios.get('/tipovi')
        .then(res => {
          console.log(res)
          setTipVina(res.data)
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

    const getAll3 = useCallback(() => {
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
        getAll2()
        getAll3()
      }, [])

    const valueInputChanged = (e) => {

        let input = e.target;
        let name = input.name;
        let value = input.value;

        novoVino[name] = value;
        setNovoVino(novoVino);
    }

    const rednerAll2 = () => {
        return tipVina.map((tipVina) => {
        return(<option key={tipVina.id} value={tipVina.id}>{tipVina.ime}</option>)
        })

    }

    const rednerAll3 = () => {
        return vinarije.map((vinarija) => {
        return(<option key={vinarija.id} value={vinarija.id}>{vinarija.ime}</option>)
        })

    }

    return(
        <div>
            <Col>
          <br/><br/>
          <Row><h1>Kreiranje vina</h1></Row>
          <br/>
          <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
              <Form>
                <Form.Label htmlFor="ime">Ime</Form.Label>
                <Form.Control id="ime" type="text" name="ime" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="opis">Opis</Form.Label>
                <Form.Control id="opis" name="opis" type="text" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="godinaProizvodnje">Godina Proizvodnje</Form.Label>
                <Form.Control id="godinaProizvodnje" name="godinaProizvodnje" type="number" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="cena">Cena</Form.Label>
                <Form.Control id="cena" name="cena" type="number" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="tipVinaId">Tip Vina</Form.Label>
                <Form.Select name='tipVinaId' onChange={(e) => valueInputChanged(e)}>
                        <option>--izaberi tip vina--</option>
                        {rednerAll2()}
                </Form.Select>
                <Form.Label htmlFor="vinarijaId">Vinarija</Form.Label>
                <Form.Select name='vinarijaId' onChange={(e) => valueInputChanged(e)}>
                        <option>--izaberi vinariju--</option>
                        {rednerAll3()}
                </Form.Select>
                <br/>
                <Button className="btn btn-success" onClick={() => dodaj()}>Kreiraj vino</Button>
              </Form>
            </Col>
            <Col></Col>
          </Row>
        </Col>
        </div>
    );


}

export default NovoVino;