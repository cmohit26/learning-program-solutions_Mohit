// src/register.js
import React from 'react';
import './App.css';

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5 ? 'Full Name must be 5 characters long!' : '';
        break;

      case 'email':
        const validEmailRegex = RegExp(
          /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\\.,;:\s@\"]+\.)+[^<>()[\]\\.,;:\s@\"]{2,})$/i
        );
        errors.email = validEmailRegex.test(value) ? '' : 'Email is not valid!';
        break;

      case 'password':
        errors.password = value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;

      default:
        break;
    }

    this.setState({ errors, [name]: value });
  };

  validateForm = (errors) => {
    return Object.values(errors).every(err => err.length === 0);
  };

  handleSubmit = (event) => {
    event.preventDefault();
    if (this.validateForm(this.state.errors)) {
      alert('Valid Form');
    } else {
      const { fullName, email, password, errors } = this.state;
      if (errors.fullName) alert(errors.fullName);
      if (errors.email) alert(errors.email);
      if (errors.password) alert(errors.password);
    }
  };

  render() {
    const { fullName, email, password } = this.state;
    return (
      <div>
        <h1 style={{ color: 'red' }}>Register Here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            Name:
            <input type="text" name="fullName" value={fullName} onChange={this.handleChange} />
          </div>
          <div>
            Email:
            <input type="text" name="email" value={email} onChange={this.handleChange} />
          </div>
          <div>
            Password:
            <input type="password" name="password" value={password} onChange={this.handleChange} />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Register;
