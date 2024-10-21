// src/components/FileList.tsx
import React from 'react';
import { StoredFile } from '../types';

interface FileListProps {
  files: StoredFile[];
}

const FileList: React.FC<FileListProps> = ({ files }) => {
  return (
    <div>
      <h2>File List</h2>
      <ul>
        {files.map(file => (
          <li key={file.id}>{file.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default FileList;
