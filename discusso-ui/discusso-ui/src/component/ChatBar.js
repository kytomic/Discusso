import React from 'react';
import { Box, Paper, InputBase, IconButton, Typography } from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import SearchIcon from '@mui/icons-material/Search';
import './style/chatBar.css';
import ChatBlock from './ChatBlock';

const ChatBar = () => {
  return (
    <Box className='chatBar'>
      <Box className='buttonBox'>
        <Box className='innerButtonBox'>
          <Typography>Chat</Typography>
          <IconButton>
            <AddIcon/>
          </IconButton>
        </Box>
        <Paper className='searchPaper'>
          <IconButton type="button" sx={{ p: '7.5px' }} aria-label="search">
            <SearchIcon />
          </IconButton>
          <InputBase />
        </Paper>
      </Box>
      <Box className='chatList'>
        <ChatBlock />
        <ChatBlock />
        <ChatBlock />
      </Box>
    </Box>
  )
}

export default ChatBar