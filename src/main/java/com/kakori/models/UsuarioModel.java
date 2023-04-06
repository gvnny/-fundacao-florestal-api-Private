package com.kakori.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_USUARIO;
	
	@Column(nullable = false, length = 50)
    private String NOME;
	
	@Column(nullable = false, length = 20)
    private String LOGIN;
	
	@Column(nullable = false, length = 50)
    private String SENHA;
	
	@Column(columnDefinition="tinyint(0) default 0")
    private boolean ADMINISTRADOR;

    public UsuarioModel() {
    }

    public UsuarioModel(int ID_USUARIO, String NOME, String LOGIN, String SENHA, boolean ADMINISTRADOR) {
        this.ID_USUARIO = ID_USUARIO;
        this.NOME = NOME;
        this.LOGIN = LOGIN;
        this.SENHA = SENHA;
        this.ADMINISTRADOR = ADMINISTRADOR;
    }
    
    /**
	 * @return the ID_USUARIO
	 */
	public int getID_USUARIO() {
		return ID_USUARIO;
	}

	/**
	 * @param ID_USUARIO the ID_USUARIO to set
	 */
	public void setID_USUARIO(int ID_USUARIO) {
		this.ID_USUARIO = ID_USUARIO;
	}

	/**
	 * @return the NOME
	 */
	public String getNOME() {
		return NOME;
	}

	/**
	 * @param NOME the NOME to set
	 */
	public void setNOME(String NOME) {
		this.NOME = NOME;
	}

	/**
	 * @return the LOGIN
	 */
	public String getLOGIN() {
		return LOGIN;
	}

	/**
	 * @param LOGIN the LOGIN to set
	 */
	public void setLOGIN(String LOGIN) {
		this.LOGIN = LOGIN;
	}

	/**
	 * @return the SENHA
	 */
	public String getSENHA() {
		return SENHA;
	}

	/**
	 * @param SENHA the SENHA to set
	 */
	public void setSENHA(String SENHA) {
		this.SENHA = SENHA;
	}

	/**
	 * @return the ADMINISTRADOR
	 */
	public boolean isADMINISTRADOR() {
		return ADMINISTRADOR;
	}

	/**
	 * @param ADMINISTRADOR the ADMINISTRADOR to set
	 */
	public void setADMINISTRADOR(boolean ADMINISTRADOR) {
		this.ADMINISTRADOR = ADMINISTRADOR;
	}

}