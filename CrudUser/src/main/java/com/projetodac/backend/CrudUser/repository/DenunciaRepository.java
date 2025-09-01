
package com.projetodac.backend.CrudUser.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projetodac.backend.CrudUser.model.Denuncia;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
    
}
