package press.turngeek.mycampaign.services;

import press.turngeek.mycampaign.model.Campaign;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

@Stateless
public class CampaignServiceBean implements CampaignService {
 
    @Inject
    EntityManager entityManager;


    @Override
    public List<Campaign> getAllCampaigns() {
        TypedQuery<Campaign> query = entityManager.createNamedQuery(Campaign.findAll, Campaign.class);
        List<Campaign> campaigns = query.getResultList();
        return campaigns;
    }
  
    public void addCampaign(Campaign campaign) {
        entityManager.persist(campaign);
    }

    public void updateCampaign(Campaign campaign) {
        entityManager.merge(campaign);
    }

    public void deleteCampaign(Campaign campaign) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaign.getId());
        entityManager.remove(managedCampaign);
    }

}