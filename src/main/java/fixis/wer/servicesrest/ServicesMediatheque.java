package fixis.wer.servicesrest;

import javax.ws.rs.*;

@Path("mediatheque")
public class ServicesMediatheque {
    @GET
    public String welcome() {
        return "Bienvenue à la médiathèque";
    }

    /*
    http://localhost:8010/fixis_rest_firstproject_war/webapi/mediatheque/message?info=Fred
     */
    @GET
    @Path("message")
    public String welcome(@QueryParam("info") String message)
    {
        return "Bienvenue " + message;
    }

    /*
    http://localhost:8010/fixis_rest_firstproject_war/webapi/mediatheque/adherents/1985
     */
    @GET
    @Path("adherents/{annee}")
    public String listeAdherentAnneeQuelconque(@PathParam("annee") String anneeDemande)
    {
        return "Liste des adhérents de l'année "+ anneeDemande;
    }

    /*
    http://localhost:8010/fixis_rest_firstproject_war/webapi/mediatheque/ajoutAdherent?n=SUZAT&p=Frederic&dn=1975-10-18
     */
    @POST
    @Path("ajoutAdherent")
    public String ajouterAdherent(@FormParam("n") String nom,
                                  @FormParam("p")String prenom,
                                  @FormParam("dn")String dateNaissance)
    {
        return "Adherent ajouté "+nom+" "+prenom+" "+" né le "+dateNaissance;
    }

    /*
    http://localhost:8010/fixis_rest_firstproject_war/webapi/mediatheque/supprimerAdherent
     */
    @DELETE
    @Path("supprimerAdherent")
    public String supprimerAdherentsAnnee(@HeaderParam("an") String annee)
    {
        return "Demande de suppression des adhérents nés en "+ annee;

    }
}
