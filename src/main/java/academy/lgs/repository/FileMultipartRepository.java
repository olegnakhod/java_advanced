package academy.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lgs.domain.FileMultipart;

@Repository
public interface FileMultipartRepository extends JpaRepository<FileMultipart, String> {}