import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class StoredFile {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ type: 'varchar' })
  name: string;

  @Column({ type: 'varchar' })
  path: string;

  @Column({ type: 'boolean' })
  isPublic: boolean;

  constructor(id?: number, name?: string, path?: string, isPublic?: boolean) {
    this.id = id ?? 0;
    this.name = name ?? '';
    this.path = path ?? '';
    this.isPublic = isPublic ?? false;
  }
}

export { StoredFile as File };
