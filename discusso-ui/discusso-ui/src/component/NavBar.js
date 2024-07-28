import React from 'react';
import { Button, Paper, TextField, Typography, Box, Avatar, Icon, IconButton } from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import ModeCommentOutlinedIcon from '@mui/icons-material/ModeCommentOutlined';
import PeopleAltIcon from '@mui/icons-material/PeopleAlt';
import SettingsIcon from '@mui/icons-material/Settings';
import './style/navbar.css';

const NavBar = () => {
  return (
    <Box className='verticalNavBar'>
      <Box className='upperButtonBox'>
        <IconButton>
          <MenuIcon/>
        </IconButton>
        <IconButton>
          <ModeCommentOutlinedIcon/>
        </IconButton>
      </Box>

      <Box className='bottomButtonBox'>
        <IconButton>
          <PeopleAltIcon/>
        </IconButton>
        <IconButton>
          <SettingsIcon/>
        </IconButton>
        <Avatar>H</Avatar>
      </Box>
    </Box>
  )
}

export default NavBar