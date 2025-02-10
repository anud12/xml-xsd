using util.repository;
using XSD;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph;
using XSD.Nworld_step.Ndata.Npeople;

namespace repository
{
    public class NodeRepository : Repository<node>
    {
        public NodeRepository() : base((element) => element.id)
        {
        }

        public NodeRepository Reindex(world_step worldStep)
        {
            Clear();
            worldStep.data?.location?.location_graph?.ForEach((locationGraph) => {
                locationGraph.node?.ForEach((node) => {
                    Add(node);
                });
            });
            return this;
        }
    }
}