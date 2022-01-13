import React, { useRef, useState } from "react"
import { Card, Button, Form, Alert } from 'react-bootstrap'
import { Link, useHistory } from "react-router-dom"
import { useAuth } from "../contexts/AuthContext"

export default function Singup() {
    const emailRef = useRef();
    const passwordRef = useRef();
    const passwordConfirmRef = useRef();
    const nicknameRef = useRef();
    const phoneNumberRef = useRef();
    const [error, setError] = useState("")
    const [loading, setLoading] = useState(false)
    const history = useHistory()
    const { signup } = useAuth()

    async function handleSumbit(e) {
        e.preventDefault()

        if (passwordRef.current.value !== passwordConfirmRef.current.value) {
            console.log("not match")
            return setError("Passwords do not match")
        }

        const newUser = {
            email: emailRef.current.value,
            password: passwordRef.current.value,
            nickname: nicknameRef.current.value,
            phoneNumber: phoneNumberRef.current.value
        };

        try {
            setError("")
            setLoading(true)
            console.log(newUser);
            await signup(newUser);
            history.push("/")
          } catch (error) {
              console.log(error);
            setError("Failed to create an account")
        }
        
        setLoading(false)
    }

    return (
        <>
            <Card>
                <Card.Body>
                    <h2 className="text-center mb-4">Sign Up</h2>
                    {error && <Alert variant="danger">{error}</Alert>}
                    <Form onSubmit={handleSumbit}>
                        <Form.Group id="email">
                            <Form.Label>Email</Form.Label>
                            <Form.Control type="email" ref={emailRef} required />
                        </Form.Group>
                        <Form.Group id="password">
                            <Form.Label>Passowrd</Form.Label>
                            <Form.Control type="password" ref={passwordRef} required />
                        </Form.Group>
                        <Form.Group id="password-confirm">
                            <Form.Label>Password Confirmation</Form.Label>
                            <Form.Control type="password" ref={passwordConfirmRef} required />
                        </Form.Group>
                        <Form.Group id="nickname">
                            <Form.Label>Nickname</Form.Label>
                            <Form.Control type="text" ref={nicknameRef} required />
                        </Form.Group>
                        <Form.Group id="phone-number">
                            <Form.Label>Phone Number</Form.Label>
                            <Form.Control type="text" ref={phoneNumberRef} required />
                        </Form.Group>
                        <Button disabled={loading} className="w-100" type="submit">
                            Sign Up
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
            <div className='w-100 text-center mt-2'>
                Already have an account? <Link to="/login">Log In</Link>
            </div>
        </>
    )
}
