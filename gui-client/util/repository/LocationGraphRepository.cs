using util.repository;
using XSD;
using XSD.Nworld_step.Ndata;
using XSD.Nworld_step.Ndata.Nlocation;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph;
using XSD.Nworld_step.Ndata.Npeople;

namespace repository
{
    public class LocationGraphRepository : Repository<location_graph>
    {
        public LocationGraphRepository() : base((element) => element.id)
        {
        }

        public LocationGraphRepository Reindex(world_step worldStep)
        {
            Clear();
            worldStep.data?.location?.location_graph?.ForEach((locationGraph) => {
                Add(locationGraph);
            });
            return this;
        }
    }
}