import { Controller, Get, Post, Body, UseInterceptors, UploadedFile } from '@nestjs/common';
import { FileInterceptor } from '@nestjs/platform-express';
import { ApiTags, ApiOperation, ApiResponse } from '@nestjs/swagger';
import { FileService } from './file.service';
import { File } from './file.entity';

interface UploadedFileType {
  originalname: string;
  path: string;
}

@ApiTags('files')
@Controller('files')
export class FileController {
  constructor(private readonly fileService: FileService) {}

  @Get()
  @ApiOperation({ summary: 'Get all files' })
  @ApiResponse({ status: 200, description: 'All files retrieved successfully.', type: [File] })
  findAll(): Promise<File[]> {
    return this.fileService.findAll();
  }

  @Post()
  @ApiOperation({ summary: 'Upload a file' })
  @ApiResponse({ status: 201, description: 'File uploaded successfully.', type: File })
  @UseInterceptors(FileInterceptor('file'))
  create(@UploadedFile() file: UploadedFileType): Promise<File> {
    console.log(file);
    return this.fileService.create({
      name: file.originalname,
      path: file.path,
      isPublic: false,
    });
  }
}
