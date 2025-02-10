using util.repository;
using XSD;
using XSD.Nworld_step.Ndata.Npeople;

namespace repository
{
    public class PersonRepository : Repository<person>
    {
        public PersonRepository() : base((element) => element.id)
        {
        }

        public PersonRepository Reindex(world_step worldStep)
        {
            Clear();
            worldStep.data?.people?.person?.ForEach((person) => Add(person));
            return this;
        }
    }
}