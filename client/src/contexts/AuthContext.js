import React, { useContext, useState, useEffect } from "react"
import axios from 'axios'

const AuthContext = React.createContext()

export function useAuth() {
  return useContext(AuthContext)
}

export function AuthProvider({ children }) {
  const [currentUser, setCurrentUser] = useState()
  const [loading, setLoading] = useState(true)

  function signup(user) {
    axios.post('http://localhost:8080/api/user/sign-up', user);
  }
  
  function login(user) {
    return axios.post('http://localhost:8080/api/auth/login', user)
    .then(res => {
        localStorage.setItem('token', res.data.accessToken)
    })
    .catch(err => {
        console.log(err);
    });
  }

  function logout() {
    localStorage.removeItem('token');
  }


  useEffect(() => {
    setCurrentUser(localStorage.getItem('token'))
    setLoading(false)
  }, [])

  const value = {
    currentUser,
    signup,
    login,
    logout
    }

  return (
    <AuthContext.Provider value={value}>
      {!loading && children}
    </AuthContext.Provider>
  )
}
