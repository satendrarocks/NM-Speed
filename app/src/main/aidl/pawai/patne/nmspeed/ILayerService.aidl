// ILayerService.aidl
package pawai.patne.nmspeed;

oneway interface ILayerService {

    void restart();

    void stop();

    void startSnapshot(long previewBytes);
}
