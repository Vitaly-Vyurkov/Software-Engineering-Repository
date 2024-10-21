// src/App.tsx
import React, { useState, useEffect } from 'react';
import { AuthProvider, useAuth } from './context/AuthContext';
import FileUploader from './components/FileUploader';
import FileList from './components/FileList';
import FolderTree from './components/FolderTree';
import Login from './components/Login';
import { getFiles } from './services/fileService';
import { StoredFile } from './types';

const App: React.FC = () => {
  const { user, logout } = useAuth();
  const [files, setFiles] = useState<StoredFile[]>([]);

  useEffect(() => {
    const fetchFiles = async () => {
      const fetchedFiles = await getFiles();
      setFiles(fetchedFiles);
    };

    fetchFiles();
  }, []);

  const handleFileUpload = async () => {
    const fetchedFiles = await getFiles();
    setFiles(fetchedFiles);
  };

  return (
    <div>
      {user ? (
        <>
          <button onClick={logout}>Logout</button>
          <FileUploader onUpload={handleFileUpload} />
          <FileList files={files} />
          <FolderTree folder={{ name: 'Root', files, folders: [] }} />
        </>
      ) : (
        <Login />
      )}
    </div>
  );
};

const WrappedApp: React.FC = () => (
  <AuthProvider>
    <App />
  </AuthProvider>
);

export default WrappedApp;
