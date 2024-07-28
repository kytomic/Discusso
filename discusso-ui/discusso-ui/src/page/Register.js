import React, {useEffect, useRef, useState} from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { Button, Paper, TextField, Typography, Box } from '@mui/material';
import Colour from '../style/Colour.js';
import Constant from '../constant/Constant.js';

import '../style/form.css';
import axios from 'axios';
import User from '../model/User.js';


const Register = () => {
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');
    let [email, setEmail] = useState('');
    let [contactNumber, setContactNumber] = useState('');
    
    let alertRef = useRef();
    let [alertText, setAlertText] = useState('');

    let navigate = useNavigate();

    const onSubmit = (e) => {
        e.preventDefault();
        // let user = new User(username, password, email, contactNumber, null);
        let iconUrl = null;
        let user = {username, password, email, contactNumber, iconUrl};
        console.log(user)

        axios.post(Constant.requestUrl + "/user/register", user).then((res) => {
            if (res.data == true) {
                navigate("/");
                return;
            }
            setAlertText('Unsuccessful registration - username has been used');
            alertRef.current.hidden = false;
            
        }).catch((err) => {
            console.log(err);
        })
    }

    return (
        <Box className='main' id='register'> 
            <Typography variant='h4' component='h4' color={Colour.headerBlue} align='center' marginBottom={6}>Discusso</Typography>
            <form method='submit'>
                <Paper sx={{borderRadius: '15px'}} elevation={6}>
                    <Box className='formBox'>
                        <Typography variant='h5' component='h5' color={Colour.headerBlue} align='center'>Register</Typography>
                        <TextField className='textField' id='username' label='Username' variant='standard' value={username} onChange={(e) => {setUsername(e.target.value)}}/>
                        <TextField className='textField' label='Password' variant='standard' type='password' value={password} onChange={(e) => {setPassword(e.target.value)}}/>
                        <TextField className='textField' label='Email' variant='standard' value={email} onChange={(e) => {setEmail(e.target.value)}}/>
                        <TextField className='textField' label='Contact Number' variant='standard' value={contactNumber} onChange={(e) => {setContactNumber(e.target.value)}}/>
                        <Button className='button' sx={{marginTop: '5rem'}} onClick={onSubmit}>Register</Button>
                        <Link className='hypertext' to='/login'>I already have an account</Link>
                        <Typography className='hypertext' ref={alertRef} variant='h6' component='h6' color={Colour.alert} align='center' hidden>{alertText}</Typography>
                    </Box>
                </Paper>
            </form>
        </Box>
    )
}

export default Register;