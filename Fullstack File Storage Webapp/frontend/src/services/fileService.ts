import axios from 'axios';
import { StoredFile } from '../types';

export const getFiles = async (): Promise<StoredFile[]> => {
  const response = await axios.get('http://localhost:3001/files');
  return response.data;
};

export const uploadFile = async (file: File): Promise<StoredFile> => {
  const formData = new FormData();
  formData.append('file', file);

  const response = await axios.post('http://localhost:3001/files', formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });

  return response.data;
};
