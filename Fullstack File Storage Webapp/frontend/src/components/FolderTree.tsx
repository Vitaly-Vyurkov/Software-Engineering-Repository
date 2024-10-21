// src/components/FolderTree.tsx
import React from 'react';

interface Folder {
  name: string;
  files: { name: string }[];
  folders: Folder[];
}

const FolderTree: React.FC<{ folder: Folder }> = ({ folder }) => (
  <div>
    <h3>{folder.name}</h3>
    <ul>
      {folder.files.map(file => (
        <li key={file.name}>{file.name}</li>
      ))}
      {folder.folders.map(subFolder => (
        <FolderTree key={subFolder.name} folder={subFolder} />
      ))}
    </ul>
  </div>
);

export default FolderTree;
