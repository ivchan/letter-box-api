package dev4c0ffee.letterboxapi.services

import dev4c0ffee.letterboxapi.entities.Issuer

interface IssuerService {
    fun listIssuers(): List<Issuer>
    fun getIssuer(id: String): Issuer
    fun addIssuer(issuer: Issuer): Issuer
    fun updateIssuer(issuer: Issuer): Issuer
    fun deleteIssuer(id: String)
}