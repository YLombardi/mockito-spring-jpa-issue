package com.geodis.rt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository<String, String> {

    /*
     * Retourne les préférences d'un utilisateur zenith
     *
     * @param zenithName le nom d'utilisateur zenith
     * @return UserPreferences une instance d'un objet qui contient toutes les préférences d'un utilisateur
     */
    String findStringById(String id);

}
