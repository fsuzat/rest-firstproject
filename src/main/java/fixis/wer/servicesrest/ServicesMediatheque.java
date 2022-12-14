package fixis.wer.servicesrest;

import mediatheque.metier.Adherent;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public String welcome(@QueryParam("info") String message) {
        return "Bienvenue " + message;
    }

    /*
    http://localhost:8010/fixis_rest_firstproject_war/webapi/mediatheque/adherents/1985
     */
    @GET
    @Path("adherents/{annee}")
    public String listeAdherentAnneeQuelconque(@PathParam("annee") String anneeDemande) {
        return "Liste des adhérents de l'année " + anneeDemande;
    }

    /*
    http://localhost:8010/fixis_rest_firstproject_war/webapi/mediatheque/ajoutAdherent?n=SUZAT&p=Frederic&dn=1975-10-18
     */
    @POST
    @Path("ajoutAdherent")
    public String ajouterAdherent(@FormParam("n") String nom,
                                  @FormParam("p") String prenom,
                                  @FormParam("dn") String dateNaissance) {
        return "Adherent ajouté " + nom + " " + prenom + " " + " né le " + dateNaissance;
    }

    /*
    http://localhost:8010/fixis_rest_firstproject_war/webapi/mediatheque/supprimerAdherent
     */
    @DELETE
    @Path("supprimerAdherent")
    public String supprimerAdherentsAnnee(@HeaderParam("an") String annee) {
        return "Demande de suppression des adhérents nés en " + annee;

    }

    @GET
    @Path("aleatoire")
    @Produces(MediaType.APPLICATION_JSON)
    public Response donnerAdherent() {
        //return Adherent.getAdherentAleatoire().toString();
        Response rep = null;
        try {
            rep = Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity(Adherent.getAdherentAleatoire())
                    .build();
        } catch (Exception e) {
            System.out.println("Erreur");
        }
        return rep;
    }
}

