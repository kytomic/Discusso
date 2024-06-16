import React, {useEffect, useState, useRef} from 'react';
import '../style/form.css';
import { Button, Paper, TextField, Typography, Box } from '@mui/material';
import Colour from '../style/Colour.js';
import axios from 'axios';
import Constant from '../constant/Constant.js';
import User from '../model/User.js';
import { Link, useNavigate } from 'react-router-dom';


const Login = () => {
    let [username, setUsername] = useState();
    let [password, setPassword] = useState();

    let alertRef = useRef();
    let [alertText, setAlertText] = useState('');

    const navigate = useNavigate();

    const onSubmit = (e) => {
        e.preventDefault();
        let user = {username, password};

        axios.post(Constant.requestUrl + "/user/login", user).then((res) => {
            if (res.data != '') {
                navigate('/main');
                return;
            }
            console.log(res.data);
            setAlertText('Incorrect username or password.');
            alertRef.current.hidden = false;
        }).catch((err) => {
            console.log(err);
        });
    }

    return (
        <Box className='main' id='login'> 
            <Typography variant='h4' component='h4' color={Colour.focus} align='center' marginBottom={6}>Discusso</Typography>
            <form method='submit'>
                <Paper sx={{borderRadius: '15px'}} elevation={6}>
                    <Box className='formBox'>
                        <Typography variant='h5' component='h5' color={Colour.focus} align='center'>Login</Typography>
                        <TextField className='textField' label='Username' variant='standard' onChange={(e) => {setUsername(e.target.value)}}/>
                        <TextField className='textField' label='Password' variant='standard' type='password' onChange={(e) => {setPassword(e.target.value)}}/>
                        <Button className='button' variant='contained' color="primary" onClick={onSubmit}>Login</Button>
                        <Link className='hypertext' to='/register'>Register an account</Link>
                        <Typography className='hypertext' ref={alertRef} variant='h6' component='h6' color={Colour.alert} align='center' hidden>{alertText}</Typography>
                    </Box>
                </Paper>
            </form>
        </Box>
    )
}

export default Login;