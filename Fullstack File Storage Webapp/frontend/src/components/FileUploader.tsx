import React, { useState } from 'react';
import { uploadFile } from '../services/fileService';

interface FileUploaderProps {
  onUpload: () => void;
}

const FileUploader: React.FC<FileUploaderProps> = ({ onUpload }) => {
  const [file, setFile] = useState<File | null>(null);

  const handleUpload = async () => {
    if (file) {
      try {
        const result = await uploadFile(file);
        console.log('File uploaded successfully:', result);
        onUpload(); // Call onUpload after file upload
      } catch (error) {
        console.error('Upload error:', error);
      }
    } else {
      console.log('No file selected');
    }
  };

  return (
    <div>
      <input type="file" onChange={(e) => setFile(e.target.files?.[0] || null)} />
      <button onClick={handleUpload}>Upload</button>
    </div>
  );
};

export default FileUploader;
