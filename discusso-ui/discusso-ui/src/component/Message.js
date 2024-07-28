import React from 'react';
import { Box, Paper, Typography } from '@mui/material';
import '../component/style/message.css';
import Colour from '../style/Colour';

const Message = () => {
  return (
    <Paper className='msg' sx={{backgroundColor: Colour.othersMsg}}>
        <Typography className='msgText'>Message...</Typography>
        <Typography className='msgTime'>11:40 pm</Typography>
    </Paper>
  )
}

export default Message