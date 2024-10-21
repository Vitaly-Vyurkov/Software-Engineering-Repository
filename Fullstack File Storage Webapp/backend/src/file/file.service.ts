import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { StoredFile } from './file.entity';

@Injectable()
export class FileService {
  constructor(
    @InjectRepository(StoredFile)
    private readonly fileRepository: Repository<StoredFile>,
  ) {}

  findAll(): Promise<StoredFile[]> {
    return this.fileRepository.find();
  }

  create(file: Partial<StoredFile>): Promise<StoredFile> {
    const newFile = this.fileRepository.create(file);
    return this.fileRepository.save(newFile);
  }
}
