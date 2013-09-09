create index IX_14675B18 on politaktivmap_Background (companyId, groupId);

create index IX_BA3B0CBF on politaktivmap_Marker (backgroundId);

create index IX_A5D6287F on politaktivmap_Picture (backgroundId);
create index IX_8A9F5BA1 on politaktivmap_Picture (name);