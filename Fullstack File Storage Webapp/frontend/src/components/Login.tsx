import React from 'react';
import { useAuth } from '../context/AuthContext';

const Login: React.FC = () => {
  const { login, setUser } = useAuth();

  const developmentAccess = () => {
    const mockUser = { name: 'Development access user' };
    setUser(mockUser);
  };

  return (
    <div>
      <button onClick={login}>Login with Google</button>
      <button onClick={developmentAccess}>Development access</button>
    </div>
  );
};

export default Login;
